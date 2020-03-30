package automation_practice.Helpers;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class MyTestRunner extends BlockJUnit4ClassRunner
{
    public MyTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
    @Override
    public void run(RunNotifier notifier)
    {
        notifier.addListener(new MyListener());
        super.run(notifier);
    }
}
