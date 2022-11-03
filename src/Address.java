import java.util.Objects;
import java.util.Scanner;

public record Address(String street, int number,
                      String zipCode, String city){

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Address that = (Address) obj;
        return this.number == that.number && Objects.equals(this.zipCode, that.zipCode);
    }
}