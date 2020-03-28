package com.javashitang.wechat.annotation;

import com.javashitang.wechat.common.EnumDefine;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTypeHandler {

    EnumDefine.EVENT_TYPE value();
}
