package com.user.animetab.model;

/*
    Status enum will show up to the user to know their account status.
    It will also be used to appropriate correct priveleges according to role.

*/

public enum Role {

    ADMIN,
    MODERATOR,
    LIMITED,
    MEMBER,
    SUSPENDED,
    BANNED;

}
