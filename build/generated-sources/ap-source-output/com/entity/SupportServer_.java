package com.entity;

import com.entity.AccountData;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-05T15:59:55")
@StaticMetamodel(SupportServer.class)
public class SupportServer_ { 

    public static volatile SingularAttribute<SupportServer, String> name;
    public static volatile SingularAttribute<SupportServer, Integer> id;
    public static volatile SingularAttribute<SupportServer, Boolean> isActive;
    public static volatile ListAttribute<SupportServer, AccountData> accountDataList;

}