package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Hello world!
 *
 */
public class App 
{
    protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main( String[] args )
    {
        logger.trace("-----trace-----:"+logger.getClass().getName());
        logger.debug("-----debug-----:"+logger.getClass().getName());
        logger.info("-----info-----");
        logger.warn("-----warn-----");
        logger.error("-----error-----");
    }
}
