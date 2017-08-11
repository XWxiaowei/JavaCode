package com.jay.spring.service;

/**
 * A test bean to test spring transaction behaviour.
 *
 * @author jay.xiang
 */
public interface SpringTxService {
    void before();

    String helloWorld();

    int mysqlConnection();

    int simpleTx();

    void txRollback();

    void txRollbackInnerTxRollbackPropagationRequires();

    void txRollbackInnerTxRollbackPropagationRequiresNew();

    void txRollbackInnerTxRollbackPropagationRequiresNew2();

    void txRollbackInnerTxRollbackPropagationRequiresNew3();

    void txRollbackInnerTxRollbackPropagationNested();

    void txRollbackInnerTxRollbackPropagationNested2();

    void txRollbackInnerTxRollbackPropagationMandatory();

    void txRollbackInnerTxRollbackPropagationMandatory2();

    void txRollbackInnerTxRollbackPropagationNever();

    void txRollbackInnerTxRollbackPropagationNever2();

    void txRollbackInnerTxRollbackPropagationNever3();

    void txRollbackInnerTxRollbackPropagationNotSupport();

    void txRollbackInnerTxRollbackPropagationNotSupport2();

    void txRollbackInnerTxRollbackPropagationSupports();

    void txRollbackInnerTxRollbackPropagationSupports2();

    void cleanUp();
}
