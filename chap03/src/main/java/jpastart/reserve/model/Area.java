package jpastart.reserve.model;

import javax.persistence.*;

@Entity
@Table(name ="Area")
public class Area {

    @Id
    @TableGenerator(  name = "idgen",           table="id_gen"
                    , pkColumnName = "entity",  pkColumnValue = "area"
                    , valueColumnName="nextid", initialValue  = 0
                    , allocationSize = 1 )
    @GeneratedValue(generator = "idgen")
    private Long id;
}
