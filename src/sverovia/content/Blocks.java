package mindustry.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class Blocks{
    public static Block

    //turrets
    rapidUno;

    public static void load(){
        //turrets

        rapidUno = new ItemTurret("rapid-uno"){{
            requirements(Category.turret, with(Items.copper, 45));
            ammo(
                Items.copper, new BasicBulletType(3.5f, 8){{ // flying speed, damage
                    width = 4f;
                    height = 9f; // one tile is 8f
                    lifetime = 60f; // 60 ticks is one second
                    ammoMultiplier = 3;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.copperAmmoBack;
                    frontColor = Pal.copperAmmoFront;
                }}
            );

            shoot = new ShootPattern(){{
                shots = 3;
                shotDelay = 4f; // Fires 3 bullets, 4 ticks apart, all from the center
            }};

            recoils = 2;
            shootSound = Sounds.shootDuo;
            recoil = 0.5f;
            shootY = 3f; // how many units do the shoot effect placed from the centre of the turret
            reload = 45f;
            range = 160;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 350;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            coolantMultiplier = 10f;
            researchCostMultiplier = 0.1f;
            depositCooldown = 2.0f;

            limitRange(5f); // a 5f buffer from the range
        }};

    }
}