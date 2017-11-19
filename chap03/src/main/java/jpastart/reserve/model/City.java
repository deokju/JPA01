package jpastart.reserve.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="City")
public class City {

    @Id
    @TableGenerator(  name = "idgen",           table="id_gen"
                    , pkColumnName = "entity",  pkColumnValue = "city"
                    , valueColumnName="nextid", initialValue  = 0
                    , allocationSize = 1 )
    @GeneratedValue(generator = "idgen")
    private Long id;
}
