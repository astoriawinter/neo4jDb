package astoria.dummymaker.scan;

import astoria.dummymaker.scan.container.PopulateContainer;
import astoria.dummymaker.scan.impl.PopulateEmbeddedFreeScanner;
import astoria.dummymaker.scan.impl.PopulateScanner;
import astoria.dummymaker.scan.container.PopulateContainer;
import astoria.dummymaker.scan.impl.PopulateEmbeddedFreeScanner;
import astoria.dummymaker.scan.impl.PopulateScanner;

import java.lang.reflect.Field;

/**
 * Scanners used by populate factory primarily
 *
 * @see PopulateScanner
 * @see PopulateEmbeddedFreeScanner
 *
 * @see PopulateContainer
 *
 * @author GoodforGod
 * @since 10.03.2018
 */
public interface IPopulateScanner extends IScanner<Field, PopulateContainer> {

}
