package com.example.KotlinTest

class SessionRequest{
    public val userId: String? = null
    public val sessionId: String? = null
}

class ActionRequest{
    public val type: String? = null
    public val session: String? = null
}

class PropertyRequest{
    public val viewedId: String? = null
    public val pageFrom: String? = null
    public val pageTo: String? = null
    public val locationX: Int? = null
    public val locationY: Int? = null
    public val actionId: Long? = null
}