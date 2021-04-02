package com.cy.pj.common.cache;

import org.springframework.stereotype.Component;

@Component//默认bean的名字为softCache
//@Component("cache")//此时bean的名字为cache
public class SoftCache implements  Cache{
}
