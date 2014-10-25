package br.edu.fcsl.gui;

import org.pushingpixels.substance.api.SubstanceConstants.ImageWatermarkKind;
import org.pushingpixels.substance.api.skin.*;
import org.pushingpixels.substance.api.skin.RavenSkin;
import org.pushingpixels.substance.api.watermark.SubstanceImageWatermark;

public class MeuSkin extends RavenSkin {
	public MeuSkin() {
		
			watermark = new SubstanceImageWatermark(
					CalcularSubrede.class.getResource("/br/edu/fcsl/gui/img/logo.jpg").getFile());
			((SubstanceImageWatermark) watermark)
					.setKind(ImageWatermarkKind.SCREEN_TILE);
			((SubstanceImageWatermark) watermark).setOpacity(0.2f);
		
	}
}
