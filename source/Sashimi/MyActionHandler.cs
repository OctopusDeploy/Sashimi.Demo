using Sashimi.Server.Contracts.ActionHandlers;
using Sashimi.Server.Contracts.Calamari;

namespace Sashimi.Demo
{
    class MyActionHandler : IActionHandler
    {
        public IActionHandlerResult Execute(IActionHandlerContext context)
        {
            return context.CalamariCommand(new CalamariFlavour("Calamari.Demo"), "my-command-name")
                .Execute();
        }

        public string Id { get; } = "Demo";
        public string Name { get; } = "Demo";
        public string Description { get; } = "Demo";
        public string? Keywords { get; }
        public bool ShowInStepTemplatePickerUI { get; }
        public bool WhenInAChildStepRunInTheContextOfTheTargetMachine { get; }
        public bool CanRunOnDeploymentTarget { get; }
        public ActionHandlerCategory[] Categories { get; } = new ActionHandlerCategory[0];
    }
}