package conf;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:${env}.properties"
)
public interface Configuration extends Config {
    String browser();
    String url();
    @Key("time.out")
    String timeOut();
}
