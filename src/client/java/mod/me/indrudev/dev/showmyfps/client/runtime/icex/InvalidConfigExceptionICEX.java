package mod.me.indrudev.dev.showmyfps.client.runtime.icex;

public class InvalidConfigExceptionICEX extends RuntimeException {

    public InvalidConfigExceptionICEX(String msg, Throwable e) {
        super("ICEX: eRROR: " + msg, e);
    }

    public InvalidConfigExceptionICEX(String msg) {
        super("ICEX: eRROR: " + msg);
    }
}
