package telephoneStation.entity.phoneCodes;

import telephoneStation.entity.Address;

import java.io.Serializable;

import static telephoneStation.entity.phoneCodes.PhoneNumberConstants.Countries;
import static telephoneStation.entity.phoneCodes.PhoneNumberConstants.MobileOperators;

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

    public PhoneNumber(){};
    public PhoneNumber(Address subAdr, String mobileOperator, String number) {

        Countries[] countries = Countries.values();
        for (Countries country : countries) {
            if (country.getCountryName().equals(subAdr.getCountry()))
                this.countryCode = country.getCountryCode();
        }

        MobileOperators[] mobileOperators = MobileOperators.values();
        for (MobileOperators operators : mobileOperators) {
            if (operators.getOperatorName().equals(mobileOperator))
                this.mobileOperator = operators.getOperatorCode();
        }

        if(this.countryCode == null)
            countryCode = "00";
        if(this.mobileOperator == null)
            this.mobileOperator = "00";
        this.number = number;
        fullPhoneNumber = countryCode + "-(" + this.mobileOperator+")-" + number;
    }

}