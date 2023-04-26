package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.*;
import jakarta.persistence.*;

//@Embeddable
public class LineItemId {

//    @Column(name = "line_item_id")
    private String value;

    public LineItemId() {
    }

    public LineItemId(String value) {
        this.value = value;
    }

    public static LineItemId of(String value){
        return new LineItemId(value);
    }
    public static LineItemId generate(){
        return new LineItemId(TsidCreator.getTsid().toString());
    }
}
