package net.daichang.starlight.server.util.render;

import net.minecraft.client.gui.screens.Screen;

import java.util.Arrays;

public class ScreenHelper {
    public static boolean isGod = false;

    public static boolean isNotAllowGui(Screen guiScreen) {
        if (guiScreen == null)
            return false;
        String[] allGuiPath = {
                "net.daichang.starlight.mc.FuckDeathScreen",
                "net.minecraft.client.gui.screens.achievement.StatsScreen",
                "net.minecraft.client.gui.screens.advancements.AdvancementsScreen",
                "net.minecraft.client.gui.screens.advancements.AdvancementTabType",
                "net.minecraft.client.gui.screens.advancements.AdvancementWidget",
                "net.minecraft.client.gui.screens.advancements.AdvancementWidgetType",
                "net.minecraft.client.gui.screens.advancements.AdvancementTab",
                "net.minecraft.client.gui.screens.controls.ControlsScreen",
                "net.minecraft.client.gui.screens.controls.KeyBindsList",
                "net.minecraft.client.gui.screens.controls.KeyBindsScreen",
                "net.minecraft.client.gui.screens.inventory.tooltip.BelowOrAboveWidgetTooltipPositioner",
                "net.minecraft.client.gui.screens.inventory.tooltip.ClientBundleTooltip",
                "net.minecraft.client.gui.screens.inventory.tooltip.ClientTextTooltip",
                "net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent",
                "net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner",
                "net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner",
                "net.minecraft.client.gui.screens.inventory.tooltip.MenuTooltipPositioner",
                "net.minecraft.client.gui.screens.inventory.tooltip.TooltipRenderUtil",
                "net.minecraft.client.gui.screens.inventory.AbstractCommandBlockEditScreen",
                "net.minecraft.client.gui.screens.inventory.AbstractContainerScreen",
                "net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen",
                "net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen",
                "net.minecraft.client.gui.screens.inventory.AnvilScreen",
                "net.minecraft.client.gui.screens.inventory.BeaconScreen",
                "net.minecraft.client.gui.screens.inventory.BlastFurnaceScreen",
                "net.minecraft.client.gui.screens.inventory.BookEditScreen",
                "net.minecraft.client.gui.screens.inventory.BookViewScreen",
                "net.minecraft.client.gui.screens.inventory.BrewingStandScreen",
                "net.minecraft.client.gui.screens.inventory.CartographyTableScreen",
                "net.minecraft.client.gui.screens.inventory.CommandBlockEditScreen",
                "net.minecraft.client.gui.screens.inventory.ContainerScreen",
                "net.minecraft.client.gui.screens.inventory.CraftingScreen",
                "net.minecraft.client.gui.screens.inventory.CreativeInventoryListener",
                "net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen",
                "net.minecraft.client.gui.screens.inventory.CyclingSlotBackground",
                "net.minecraft.client.gui.screens.inventory.DispenserScreen",
                "net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen",
                "net.minecraft.client.gui.screens.inventory.EnchantmentNames",
                "net.minecraft.client.gui.screens.inventory.EnchantmentScreen",
                "net.minecraft.client.gui.screens.inventory.FurnaceScreen",
                "net.minecraft.client.gui.screens.inventory.GrindstoneScreen",
                "net.minecraft.client.gui.screens.inventory.HangingSignEditScreen",
                "net.minecraft.client.gui.screens.inventory.HopperScreen",
                "net.minecraft.client.gui.screens.inventory.HorseInventoryScreen",
                "net.minecraft.client.gui.screens.inventory.InventoryScreen",
                "net.minecraft.client.gui.screens.inventory.ItemCombinerScreen",
                "net.minecraft.client.gui.screens.inventory.JigsawBlockEditScreen",
                "net.minecraft.client.gui.screens.inventory.LecternScreen",
                "net.minecraft.client.gui.screens.inventory.LoomScreen",
                "net.minecraft.client.gui.screens.inventory.MenuAccess",
                "net.minecraft.client.gui.screens.inventory.MerchantScreen",
                "net.minecraft.client.gui.screens.inventory.MinecartCommandBlockEditScreen",
                "net.minecraft.client.gui.screens.inventory.PageButton",
                "net.minecraft.client.gui.screens.inventory.ShulkerBoxScreen",
                "net.minecraft.client.gui.screens.inventory.SignEditScreen",
                "net.minecraft.client.gui.screens.inventory.SmithingScreen",
                "net.minecraft.client.gui.screens.inventory.SmokerScreen",
                "net.minecraft.client.gui.screens.inventory.StonecutterScreen",
                "net.minecraft.client.gui.screens.inventory.StructureBlockEditScreen",
                "net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen",
                "net.minecraft.client.gui.screens.multiplayer.Realms32bitWarningScreen",
                "net.minecraft.client.gui.screens.multiplayer.SafetyScreen",
                "net.minecraft.client.gui.screens.multiplayer.ServerSelectionList",
                "net.minecraft.client.gui.screens.multiplayer.WarningScreen",
                "net.minecraft.client.gui.screens.packs.PackSelectionModel",
                "net.minecraft.client.gui.screens.packs.PackSelectionScreen",
                "net.minecraft.client.gui.screens.packs.TransferableSelectionList",
                "net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent",
                "net.minecraft.client.gui.screens.recipebook.BlastingRecipeBookComponent",
                "net.minecraft.client.gui.screens.recipebook.GhostRecipe",
                "net.minecraft.client.gui.screens.recipebook.OverlayRecipeComponent",
                "net.minecraft.client.gui.screens.recipebook.RecipeBookComponent",
                "net.minecraft.client.gui.screens.recipebook.RecipeBookPage",
                "net.minecraft.client.gui.screens.recipebook.RecipeBookTabButton",
                "net.minecraft.client.gui.screens.recipebook.RecipeButton",
                "net.minecraft.client.gui.screens.recipebook.RecipeCollection",
                "net.minecraft.client.gui.screens.recipebook.RecipeShownListener",
                "net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener",
                "net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent",
                "net.minecraft.client.gui.screens.recipebook.SmokingRecipeBookComponent",
                "net.minecraft.client.gui.screens.reporting.ChatReportScreen",
                "net.minecraft.client.gui.screens.reporting.ChatSelectionLogFiller",
                "net.minecraft.client.gui.screens.reporting.ChatSelectionScreen",
                "net.minecraft.client.gui.screens.reporting.ReportReasonSelectionScreen",
                "net.minecraft.client.gui.screens.social.PlayerEntry",
                "net.minecraft.client.gui.screens.social.PlayerSocialManager",
                "net.minecraft.client.gui.screens.social.SocialInteractionsPlayerList",
                "net.minecraft.client.gui.screens.social.SocialInteractionsScreen",
                "net.minecraft.client.gui.screens.telemetry.TelemetryEventWidget",
                "net.minecraft.client.gui.screens.telemetry.TelemetryInfoScreen",
                "net.minecraft.client.gui.screens.worldselection.ConfirmExperimentalFeaturesScreen",
                "net.minecraft.client.gui.screens.worldselection.CreateWorldScreen",
                "net.minecraft.client.gui.screens.worldselection.EditGameRulesScreen",
                "net.minecraft.client.gui.screens.worldselection.EditWorldScreen",
                "net.minecraft.client.gui.screens.worldselection.ExperimentsScreen",
                "net.minecraft.client.gui.screens.worldselection.OptimizeWorldScreen",
                "net.minecraft.client.gui.screens.worldselection.PresetEditor",
                "net.minecraft.client.gui.screens.worldselection.SelectWorldScreen",
                "net.minecraft.client.gui.screens.worldselection.SwitchGrid",
                "net.minecraft.client.gui.screens.worldselection.WorldCreationContext",
                "net.minecraft.client.gui.screens.worldselection.WorldCreationUiState",
                "net.minecraft.client.gui.screens.worldselection.WorldOpenFlows",
                "net.minecraft.client.gui.screens.worldselection.WorldSelectionList",
                "net.minecraft.client.gui.screens.AccessibilityOnboardingScreen",
                "net.minecraft.client.gui.screens.AccessibilityOptionsScreen",
                "net.minecraft.client.gui.screens.AlertScreen",
                "net.minecraft.client.gui.screens.BackupConfirmScreen",
                "net.minecraft.client.gui.screens.BanNoticeScreen",
                "net.minecraft.client.gui.screens.ChatOptionsScreen",
                "net.minecraft.client.gui.screens.ChatScreen",
                "net.minecraft.client.gui.screens.ConfirmLinkScreen",
                "net.minecraft.client.gui.screens.ConfirmScreen",
                "net.minecraft.client.gui.screens.ConnectScreen",
                "net.minecraft.client.gui.screens.CreateBuffetWorldScreen",
                "net.minecraft.client.gui.screens.CreateFlatWorldScreen",
                "net.minecraft.client.gui.screens.CreditsAndAttributionScreen",
                "net.minecraft.client.gui.screens.DatapackLoadFailureScreen",
                "net.minecraft.client.gui.screens.DemoIntroScreen",
                "net.minecraft.client.gui.screens.DirectJoinServerScreen",
                "net.minecraft.client.gui.screens.DisconnectedScreen",
                "net.minecraft.client.gui.screens.EditServerScreen",
                "net.minecraft.client.gui.screens.ErrorScreen",
                "net.minecraft.client.gui.screens.FaviconTexture",
                "net.minecraft.client.gui.screens.GenericDirtMessageScreen",
                "net.minecraft.client.gui.screens.GenericWaitingScreen",
                "net.minecraft.client.gui.screens.InBedChatScreen",
                "net.minecraft.client.gui.screens.LanguageSelectScreen",
                "net.minecraft.client.gui.screens.LevelLoadingScreen",
                "net.minecraft.client.gui.screens.LoadingDotsText",
                "net.minecraft.client.gui.screens.LoadingOverlay",
                "net.minecraft.client.gui.screens.MenuScreens",
                "net.minecraft.client.gui.screens.MouseSettingsScreen",
                "net.minecraft.client.gui.screens.OnlineOptionsScreen",
                "net.minecraft.client.gui.screens.OptionsScreen",
                "net.minecraft.client.gui.screens.OptionsSubScreen",
                "net.minecraft.client.gui.screens.OutOfMemoryScreen",
                "net.minecraft.client.gui.screens.Overlay",
                "net.minecraft.client.gui.screens.PauseScreen",
                "net.minecraft.client.gui.screens.PopupScreen",
                "net.minecraft.client.gui.screens.PresetFlatWorldScreen",
                "net.minecraft.client.gui.screens.ProgressScreen",
                "net.minecraft.client.gui.screens.ReceivingLevelScreen",
                "net.minecraft.client.gui.screens.Screen",
                "net.minecraft.client.gui.screens.ShareToLanScreen",
                "net.minecraft.client.gui.screens.SimpleOptionsSubScreen",
                "net.minecraft.client.gui.screens.SkinCustomizationScreen",
                "net.minecraft.client.gui.screens.SoundOptionsScreen",
                "net.minecraft.client.gui.screens.SymlinkWarningScreen",
                "net.minecraft.client.gui.screens.TitleScreen",
                "net.minecraft.client.gui.screens.VideoSettingsScreen",
                "net.minecraft.client.gui.screens.WinScreen",
                "net.minecraft.client.gui.screens.debug.GameModeSwitcherScreen",
                "net.minecraft.client.gui.screens.DeathScreen",
                "net.minecraftforge.client.gui.ModListScreen",
                "net/daichang/starlight/client/window/minecraft/StarlightOptionScreen"
        };
        return !Arrays.asList(allGuiPath).contains(guiScreen.getClass().getName());
    }
}
