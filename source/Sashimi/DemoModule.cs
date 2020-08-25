using Autofac;
using Sashimi.Server.Contracts.ActionHandlers;

namespace Sashimi.Demo
{
    public class DemoModule : Module
    {
        protected override void Load(ContainerBuilder builder)
        {
            builder.RegisterType<MyActionHandler>().As<IActionHandler>().AsSelf()
                .InstancePerLifetimeScope();

        }
    }
}