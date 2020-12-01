package java21.com;

public class ZipCode {
    private String zipCode = "";

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void validateZipCode(){
        if(zipCode.length()==6 || zipCode.contains("-")){
            System.out.println("Zip Code: " + zipCode);
        }else{
            System.out.println("Zip Code has incorrect format!");
        }
    }
}
