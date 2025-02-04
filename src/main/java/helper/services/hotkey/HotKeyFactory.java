package helper.services.hotkey;

import helper.frame.utils.DiyKeyUtil;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author @_@
 */
public class HotKeyFactory {
	private static final HashMap<Integer, HotKeyConsumer> HOT_KEY_MAP = new HashMap<>(10);

	public static void loadDefaultHotKeys() {
		HOT_KEY_MAP.put(NativeKeyEvent.VC_F1, new SendMyTeamScoreConsumer());
		HOT_KEY_MAP.put(NativeKeyEvent.VC_F2, new SendOtherTeamScoreConsumer());
		HOT_KEY_MAP.put(NativeKeyEvent.VC_END, new CaiHongPiConsumer());
		HOT_KEY_MAP.put(NativeKeyEvent.VC_HOME, new GarbageWordConsumer());
		HOT_KEY_MAP.put(NativeKeyEvent.VC_DELETE, new MarkWordDeleteConsumer());
		HOT_KEY_MAP.put(NativeKeyEvent.VC_PAUSE, new ControlAutoFuncConsumer());
	}

	public static HotKeyConsumer getHotKeyConsumer(int keyCode) {
		return HOT_KEY_MAP.get(keyCode);
	}

	public static void clearHotKeys() {
		HOT_KEY_MAP.clear();
		loadDefaultHotKeys();
	}

	public static void applyDiyKey() {
		ArrayList<String> list = DiyKeyUtil.loadKey();
		Map<Integer, HotKeyConsumer> map = DiyKeyUtil.parseKey2Consumer(list);
		applyDiyKey(map);
	}

	public static void applyDiyKey(Map<Integer, HotKeyConsumer> map) {
		clearHotKeys();
		HOT_KEY_MAP.putAll(map);
	}

}
