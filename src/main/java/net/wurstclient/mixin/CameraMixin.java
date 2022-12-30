/*
 * Copyright (c) 2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.Camera;

@Mixin(Camera.class)
public abstract class CameraMixin
{
	@Inject(at = @At("HEAD"), method = "getMaxZoom(D)D", cancellable = true)
	private void onGetMaxZoom(double desiredCameraDistance,
		CallbackInfoReturnable<Double> cir)
	{
		cir.setReturnValue(desiredCameraDistance);
	}
}
