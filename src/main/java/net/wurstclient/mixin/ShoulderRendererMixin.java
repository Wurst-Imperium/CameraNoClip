/*
 * Copyright (c) 2014-2023 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.render.Camera;
import net.minecraft.world.World;

@Pseudo
@Mixin(targets = "com.teamderpy.shouldersurfing.client.ShoulderRenderer",
	remap = false)
public abstract class ShoulderRendererMixin
{
	@Inject(at = @At("HEAD"), method = "calcCameraDistance", cancellable = true)
	private void calcCameraDistance(Camera camera, World level,
		double desiredCameraDistance, CallbackInfoReturnable<Double> cir)
	{
		cir.setReturnValue(desiredCameraDistance);
	}
}
