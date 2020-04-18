//package com.jay.util;
//
//
//public class ValidationUtil {
//
//    private static final Validator validator =
//            Validation.byProvider(HibernateValidator.class)
//                    .configure()
//                    //快速返回
//                    .failFast(true)
//                    .buildValidatorFactory()
//                    .getValidator();
//
//    private ValidationUtil() {
//
//    }
//
//
//    public static <T> String getMessage(T obj) {
//        Set<ConstraintViolation<Object>> set = validator.validate(obj);
//        for (ConstraintViolation<Object> constraintViolation : set) {
//            return constraintViolation.getMessage();
//        }
//        return null;
//    }
//
//}
