package dev.based.vampyrix.impl.clickgui;

import dev.based.vampyrix.api.util.Wrapper;
import dev.based.vampyrix.impl.clickgui.frame.Frame;
import dev.based.vampyrix.api.module.Category;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;

public class ClickGUIScreen extends GuiScreen implements Wrapper {
    public static ClickGUIScreen INSTANCE;

    private final ArrayList<Frame> frames = new ArrayList<>();

    public ClickGUIScreen() {
        int xOffset = 10;
        for (Category category : Category.values()) {
            this.frames.add(new Frame(category, this.getVampyrix().getModuleManager().getModulesByCategory(category), 10 + xOffset, 10, 100, 16));
            xOffset += 105;
        }

        INSTANCE = this;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for (Frame frame : this.frames) {
            frame.render(mouseX, mouseY, partialTicks);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (Frame frame : this.frames) {
            frame.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        for (Frame frame : this.frames) {
            frame.mouseReleased(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void keyTyped(char keychar, int keycode) throws IOException {
        for (Frame frame : this.frames) {
            frame.keyTyped(keychar, keycode);
        }

        super.keyTyped(keychar, keycode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}