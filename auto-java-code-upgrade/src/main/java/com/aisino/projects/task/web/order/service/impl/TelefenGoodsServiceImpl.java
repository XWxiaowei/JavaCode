package com.aisino.projects.task.web.order.service.impl;
import com.aisino.projects.task.model.TelefenGoods;
import com.aisino.projects.task.web.base.ServiceImpl;
import org.springframework.stereotype.Service;
import 
Expression daoTargetPackage is undefined on line 5, column 10 in serviceImplTemplate.ftl.
The problematic instruction:
----------
==> ${daoTargetPackage} [on line 5, column 8 in serviceImplTemplate.ftl]
----------

Java backtrace for programmers:
----------
freemarker.core.InvalidReferenceException: Expression daoTargetPackage is undefined on line 5, column 10 in serviceImplTemplate.ftl.
	at freemarker.core.TemplateObject.assertNonNull(TemplateObject.java:125)
	at freemarker.core.Expression.getStringValue(Expression.java:118)
	at freemarker.core.Expression.getStringValue(Expression.java:93)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:76)
	at freemarker.core.Environment.visit(Environment.java:221)
	at freemarker.core.MixedContent.accept(MixedContent.java:92)
	at freemarker.core.Environment.visit(Environment.java:221)
	at freemarker.core.Environment.process(Environment.java:199)
	at freemarker.template.Template.process(Template.java:259)
	at com.jay.generator.api.AutoGenerationJavaCodeUpgrade.autoGenerationJavaCode(AutoGenerationJavaCodeUpgrade.java:87)
	at com.jay.generator.GeneratorStartUp.main(GeneratorStartUp.java:64)
