package com.tian.designpattern.caching;

/**
* The Caching pattern describes how to avoid expensive re-acquisition of resources by not releasing
* the resources immediately after their use. The resources retain their identity, are kept in some
* fast-access storage, and are re-used to avoid having to acquire them again. There are four main
* caching strategies/techniques in this pattern; each with their own pros and cons. They are;
* <b><code>write-through</code></b> which writes data to the cache and DB in a single transaction,
* <code>write-around</code> which writes data immediately into the DB instead of the cache,
* <code>write-behind</code> which writes data into the cache initially whilst the data is only
* written into the DB when the cache is full, and <code>cache-aside</code> which pushes the
* responsibility of keeping the data synchronized in both data sources to the application itself.
* The <code>read-through</code> strategy is also included in the mentioned four strategies --
* returns data from the cache to the caller <b>if</b> it exists <b>else</b> queries from DB and
* stores it into the cache for future use. These strategies determine when the data in the cache
* should be written back to the backing store (i.e. Database) and help keep both data sources
* synchronized/up-to-date. This pattern can improve performance and also helps to maintain
* consistency between data held in the cache and the data in the underlying data store.
* <p>
*/

public class CachingMain {

}
