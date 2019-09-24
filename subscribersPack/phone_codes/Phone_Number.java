package telephone_station.subscribersPack.phone_codes;

import telephone_station.address.Address;

import java.io.Serializable;

public class Phone_Number  implements Serializable {


    private String countryCode;
    private String mobileOperator;
    public String number;

    public void setFullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
    }

    private String fullPhoneNumber;

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

    public Phone_Number(){}

    public Phone_Number(Address subAdr, String mobileOperator, String number) {
        switch(subAdr.Country){
            case ("Ukraine"):
                countryCode = "+380";
                break;
            case ("Russia"):
                countryCode = "+7";
                break;
            case ("Belarus"):
                countryCode = "+375";
                break;
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
        }
        this.number = number;
        fullPhoneNumber = countryCode + "-(" + this.mobileOperator+")-"+number;
    }

}
