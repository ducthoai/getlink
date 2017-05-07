package com.entity;

import com.entity.SupportServer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-07T18:16:35")
@StaticMetamodel(AccountData.class)
public class AccountData_ { 

    public static volatile SingularAttribute<AccountData, Boolean> isAlive;
    public static volatile SingularAttribute<AccountData, SupportServer> server;
    public static volatile SingularAttribute<AccountData, String> password;
    public static volatile SingularAttribute<AccountData, String> name;
    public static volatile SingularAttribute<AccountData, Integer> id;
    public static volatile SingularAttribute<AccountData, Boolean> isActive;
    public static volatile SingularAttribute<AccountData, String> email;

}