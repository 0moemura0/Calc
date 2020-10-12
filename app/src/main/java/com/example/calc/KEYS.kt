package com.example.calc

import com.udojava.evalex.*

enum class KEYS(val beauty: String, val not_beauty: String = beauty) {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    ZERO("0"),

    SEP("."),

    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    POW("^"),
    SQRT("", "SQRT("),
    F("FACT("),


    PI(960.toChar().toString(), Expression.PI.toString()),
    E("e", Expression.e.toString()),

    SIN("SIN("),
    ASIN("ASIN("),
    COS("COS("),
    ACOS("ACOS("),
    TAN("TAN("),
    ATAN("ATAN("),
    COT("COT("),
    ACOT("ACOT("),

    LOG("LOG10("),
    LN("LOG("),

    S_L("("),
    S_R(")")


}