package tbca.engine.action;

public final class ActionFactory {
    private ActionFactory() {
    }

    // TODO
    public static Action create(ActionParameters actionParameters) {
        return switch (actionParameters.actionType()) {
            case BASIC_ATTACK -> new BasicAttackAction((BasicAttackActionParameters) actionParameters);
            case DEFEND -> new DefendAction(actionParameters);
            case USE_ITEM -> new UseItemAction(actionParameters);
            case SPECIAL_SKILL -> new SpecialSkillAction(actionParameters);
        };
    }
}
