package com.RealLis.common.annotation;

import java.lang.annotation.*;
import com.RealLis.common.enums.DataSourceType;
/**
 * 自定义多数据源切换注解
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    public DataSourceType value() default DataSourceType.MASTER;
}
