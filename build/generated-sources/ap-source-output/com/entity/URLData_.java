package com.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-04T22:14:45")
@StaticMetamodel(URLData.class)
public class URLData_ { 

    public static volatile SingularAttribute<URLData, Date> receiveTime;
    public static volatile SingularAttribute<URLData, String> originProcessURI;
    public static volatile SingularAttribute<URLData, String> identity;
    public static volatile SingularAttribute<URLData, Boolean> isProcessed;
    public static volatile SingularAttribute<URLData, Boolean> isServe;
    public static volatile SingularAttribute<URLData, String> originRequestURL;
    public static volatile SingularAttribute<URLData, Integer> id;
    public static volatile SingularAttribute<URLData, String> originResultURL;
    public static volatile SingularAttribute<URLData, Boolean> isLeech;
    public static volatile SingularAttribute<URLData, String> finalURL;
    public static volatile SingularAttribute<URLData, Integer> retry;
    public static volatile SingularAttribute<URLData, Integer> status;

}