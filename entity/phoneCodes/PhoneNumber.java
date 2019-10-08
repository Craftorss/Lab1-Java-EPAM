package telephoneStation.entity.phoneCodes;

import telephoneStation.entity.Address;

import java.io.Serializable;

public class PhoneNumber implements Serializable {


    private String countryCode;
    private String mobileOperator;
    private String number;
    private String fullPhoneNumber;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setFullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
    }



    public String getFullPhoneNumber() {
        return fullPhoneNumber;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public PhoneNumber(){}

    public PhoneNumber(Address subAdr, String mobileOperator, String number) {
        switch(subAdr.getCountry()){
            case ("Ukraine"):
                countryCode = "+380";
                break;
            case ("Russia"):
                countryCode = "+7";
                break;
            case ("Belarus"):
                countryCode = "+375";
                break;
            default:
                countryCode = "000";
        }
        switch (mobileOperator)
        {
            case ("Life"):
                this.mobileOperator = "25";
                break;

            case("МТС"):
                this.mobileOperator = "29";
                break;

            case("Velcom"):
                this.mobileOperator = "44";
                break;

            default:
                this.mobileOperator = "00";
        }
        this.number = number;
        fullPhoneNumber = countryCode + "-(" + this.mobileOperator+")-" + number;
    }

}
