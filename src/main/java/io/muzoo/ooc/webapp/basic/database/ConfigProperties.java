package io.muzoo.ooc.webapp.basic.database;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ConfigProperties {

    private String databaseUser;
    private String databasePassword;
    private String databaseDriver;
    private String databaseConnectionUrl;

}
