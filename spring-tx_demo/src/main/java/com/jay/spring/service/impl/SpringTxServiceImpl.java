package com.jay.spring.service.impl;

import com.jay.spring.exception.CustomRuntimeException;
import com.jay.spring.service.SpringTxService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author khotyn 9/14/13 1:46 PM
 */
@Service
public class SpringTxServiceImpl implements SpringTxService {
    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;
    private TransactionTemplate requiresNewTransactionTemplate;
    private TransactionTemplate nestedTransactionTemplate;
    private TransactionTemplate mandatoryTransactionTemplate;
    private TransactionTemplate neverTransactionTemplate;
    private TransactionTemplate notSupportedTransactionTemplate;
    private TransactionTemplate supportsTransactionTemplate;

    @Override
    public void before() {
        jdbcTemplate.update("INSERT  INTO USER (name,password) VALUES (?,?)","xiang","11111112");
    }

    @Override
    public String helloWorld() {
        return "hello world";
    }

    @Override
    public int mysqlConnection() {
        return countUser();
    }

    @Override
    public int simpleTx() {
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus transactionStatus) {
                return countUser();
            }
        });
    }

    @Override
    public void txRollback() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("INSERT INTO  USER (name,password) VALUES (?,?)","Huang","1111231");
                throw  new RuntimeException("Rollback!");
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationRequires() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("INSERT INTO  USER (name,password) VALUES (?,?)","Huang","1111231");
                transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                        //内部事务设置了 setRollbackOnly
                        transactionStatus.setRollbackOnly();
                    }
                });
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationRequiresNew() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                requiresNewTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                    }
                });
                //外部事务发生回滚,内部事务应该不受影响还是能够提交
                throw new RuntimeException();
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationRequiresNew2() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                requiresNewTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                        // 内部事务发生回滚，但是外部事务不应该发生回滚
                        transactionStatus.setRollbackOnly();
                    }
                });
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationRequiresNew3() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                requiresNewTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                        // 内部事务抛出 RuntimeException，外部事务接收到异常，依旧会发生回滚
                        throw new RuntimeException();
                    }
                });
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationNested() {
        nestedTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                nestedTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                                "1111112");
                        // 内部事务设置了 rollbackOnly，外部事务应该不受影响，可以继续提交
                        transactionStatus.setRollbackOnly();
                    }
                });
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationNested2() {
        nestedTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                nestedTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                    }
                });
                // 外部事务设置了 rollbackOnly，内部事务应该也被回滚掉
                transactionStatus.setRollbackOnly();
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationMandatory() {
        mandatoryTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationMandatory2() {
        nestedTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                mandatoryTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                        //内部事务回滚了,外部事务也跟着回滚
                        transactionStatus.setRollbackOnly();
                    }
                });
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationNever() {
        neverTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationNever2() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                neverTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                    }
                });
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationNever3() {
        neverTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                neverTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                    }
                });
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationNotSupport() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                notSupportedTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                    }
                });
                // 外部事务回滚，不会把内部的也连着回滚
                transactionStatus.setRollbackOnly();
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationNotSupport2() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    notSupportedTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                        @Override
                        protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                            jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                    "Huang", "1111112");
                            throw new CustomRuntimeException();
                        }
                    });
                } catch (CustomRuntimeException e) {
                }
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationSupports() {
        supportsTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                throw new CustomRuntimeException();
            }
        });
    }

    @Override
    public void txRollbackInnerTxRollbackPropagationSupports2() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into user (name, password) values (?, ?)", "Huang",
                        "1111112");
                supportsTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {
                        jdbcTemplate.update("insert into user (name, password) values (?, ?)",
                                "Huang", "1111112");
                        status.setRollbackOnly();
                    }
                });
            }
        });
    }

    @Override
    public void cleanUp() {
        jdbcTemplate.update("DELETE FROM USER ");
    }

    private int countUser(){
        return jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate =new JdbcTemplate(dataSource);
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setRequiresNewTransactionTemplate(TransactionTemplate requiresNewTransactionTemplate) {
        this.requiresNewTransactionTemplate = requiresNewTransactionTemplate;
    }

    public void setNestedTransactionTemplate(TransactionTemplate nestedTransactionTemplate) {
        this.nestedTransactionTemplate = nestedTransactionTemplate;
    }

    public void setMandatoryTransactionTemplate(TransactionTemplate mandatoryTransactionTemplate) {
        this.mandatoryTransactionTemplate = mandatoryTransactionTemplate;
    }

    public void setNeverTransactionTemplate(TransactionTemplate neverTransactionTemplate) {
        this.neverTransactionTemplate = neverTransactionTemplate;
    }

    public void setNotSupportedTransactionTemplate(TransactionTemplate notSupportedTransactionTemplate) {
        this.notSupportedTransactionTemplate = notSupportedTransactionTemplate;
    }

    public void setSupportsTransactionTemplate(TransactionTemplate supportsTransactionTemplate) {
        this.supportsTransactionTemplate = supportsTransactionTemplate;
    }
}
