package read.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Country {
    private String name;
    private String shortCode;

    @Override
    public String toString(){
        return name + "::" + shortCode;
    }
}
