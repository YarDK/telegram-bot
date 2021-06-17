package src.gitdoc;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Reply;

import static org.telegram.abilitybots.api.objects.Flag.MESSAGE;
import static org.telegram.abilitybots.api.objects.Flag.REPLY;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class HelloBot extends AbilityBot {
    public static String BOT_TOKEN = "1850446193:AAFPb7mzekHn1oHoQpENdy6cm9o2MvBZRH4";
    public static String BOT_USERNAME = "Ps5yardk_bot";

    public final String url_ps5 = "https://www.citilink.ru/product/igrovaya-konsol-playstation-5-digital-edition-ps719398806-belyi-cherny-1476354/";

    private final ChromeChek cc = new ChromeChek();

    public HelloBot() {
        super(BOT_TOKEN, BOT_USERNAME);
    }

    // Your user ID: 588751784
    // Current chat ID: 588751784

    @Override
    public long creatorId() {
        return 588751784;
    }

    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("says hello world!")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("Hello world!", ctx.chatId()))
                .build();
    }

    public Ability sayAssole() {
        return Ability
                .builder()
                .name("ass")
                .info("ЖОПА! =D")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("Да просто жопа, и все тут", ctx.chatId()))
                .build();
    }

    public Ability sayUrly() {


        return Ability
                .builder()
                .name("url")
                .info("URL citilink ps5")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send(url_ps5, ctx.chatId()))
                .build();
    }

    public Ability chekAvailable() {
        return Ability
                .builder()
                .name("check")
                .info("check")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.forceReply("Птыаюсь провреить...", ctx.chatId()))
                .action(ctx -> silent.send(chromeCheck(), ctx.chatId()))
                .build();
    }

    private String chromeCheck() {
        try {
            cc.init(url_ps5);
            cc.stop();
            return cc.getResult();
        } catch (Exception e){
            e.printStackTrace();
            return "Чет не вышло =(";
        }

    }
}
