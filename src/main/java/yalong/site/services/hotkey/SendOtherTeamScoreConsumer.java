package yalong.site.services.hotkey;

import yalong.site.cache.GameDataCache;
import yalong.site.utils.KeyEventUtil;

import java.util.function.Consumer;

/**
 * @author yalong
 */
public class SendOtherTeamScoreConsumer implements HotKeyConsumer {

	@Override
	public Consumer<Integer> build() {
		return i -> {
			for (String s : GameDataCache.otherTeamScore) {
				KeyEventUtil.sendMsg("对方" + s);
			}
		};
	}
}
