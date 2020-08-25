using Calamari.Demo;
using NUnit.Framework;
using Sashimi.Tests.Shared.Server;

namespace Sashimi.Demo.Tests
{
    [TestFixture]
    public class MyActionHandlerFixture
    {
        [Test]
        public void Test1()
        {
            ActionHandlerTestBuilder.CreateAsync<MyActionHandler, Program>()
                .WithArrange(context =>
                {

                })
                .Execute();
        }
    }
}