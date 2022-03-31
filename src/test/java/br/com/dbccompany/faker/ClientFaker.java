package br.com.dbccompany.faker;

public class ClientFaker {

    public static String getValidClientContentFake() {
        return "002ç2345675434544345çJose da SilvaçRural";
    }

    public static String getInvalidIdClientContentFake() {
        return "999ç2345675434544345çJose da SilvaçRural";
    }

    public static String getInvalidSeparatorClientContentFake() {
        return "002#2345675434544345#Jose da Silva#Rural";
    }
}
