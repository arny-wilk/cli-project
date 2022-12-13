package enums;

public class Enum {

    public enum ADDRESS_TYPE {
        HOME, BUSINESS, BILLING, SHIPPING, CONTRACT, AR_ADDRESS, RECIPIENT
    }

    public enum GENDER {
        MALE, FEMALE
    }

    public enum COUNTRY {
        FRANCE, ENGLAND, USA, SPAIN, ITALY, AUSTRIA, POLAND, DEUSTSHLAND, INDIA, CHINA, JAPAN, KOREA, BRASIL, ARGENTINA
    }

    public enum ISO_ALPHA2 {
        GB("GB")
        , FR("FR")
        , D("D")
        , SP("SP")
        , P("P")
        , I("I")
        , PL("PL")
        , NL("NL")
        , DK("DK");

        private final String isoAlpha2;
        private String s;

        ISO_ALPHA2(String isoAlpha2) {
            this.isoAlpha2 = isoAlpha2;
        }

        public boolean isInRegNumber(String s) {
            this.s = s;
            return s.contains(isoAlpha2);
        }
    }

    public enum COLOR {
        RED, GREEN, BLUE, BROWN, ORANGE, VIOLET, BLACK, WHITE, ROSE, MAUVE, GREY
    }

    public enum DRIVING_LICENCE_CATEGORY {
        B, EB, P, PB
    }

    public enum VEHICULE_CATEGORY {
        SEDAN, COUPE, SPORTS, STATION_WAGON, HATCHBACK, CONVERTIBLE, SUV, MINIVAN, PICKUP
    }

    public enum VEHICULE_TYPE {
        THERMIC, ELECTRIC
    }

    public enum ENGINE_TYPE {
        IFOUR("I-4")
        , IFIVE("I-5")
        , ISIX("I-6")
        , VSIX("V-6")
        , VEIGHT("V-8")
        , VTWELVE("V-12")
        , VTEN("V-10")
        , HFOUR("H-4")
        , HSIX("H-6");

        public final String engineConfig;

        ENGINE_TYPE(String engineConfig) {
            this.engineConfig = engineConfig;
        }
    }
}
