package org.multibit.exchange.service;

import java.util.List;
import org.multibit.exchange.readmodel.MarketReadModel;

/**
 * <p>ReadService to provide the following to the application:</p>
 * <ul>
 * <li>Read-only access to Market information</li>
 * </ul>
 *
 * @since 0.0.1
 *         
 */
public interface MarketReadService {
  List<MarketReadModel> fetchMarkets();
}
