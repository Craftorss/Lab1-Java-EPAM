package telephoneStation.entity.phoneCodes;

public final class PhoneNumberConstants {
    public enum Countries{
        UKRAINE("Ukraine","+380"),
        RUSSIA("Russia","+7"),
        BELARUS("Belarus","+375");
        private  String countryName;
        private  String countryCode;

        Countries(String countryName, String countryCode) {
            this.countryName = countryName;
            this.countryCode = countryCode;
        }

        public String getCountryName() {
            return countryName;
        }
        public String getCountryCode() {
            return countryCode;
        }
    }

    public enum MobileOperators{
        MTC("МТС","29"),
        LIFE("Life","25"),
        VELCOM("Velcom", "44");
        private String operatorName;
        private String operatorCode;

        MobileOperators(String operatorName, String operatorCode) {
            this.operatorName = operatorName;
            this.operatorCode = operatorCode;
        }

        public String getOperatorName() {
            return operatorName;
        }
        public String getOperatorCode() {
            return operatorCode;
        }
    }


}
