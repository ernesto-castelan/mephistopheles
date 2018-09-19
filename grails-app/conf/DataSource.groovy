hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

environments {
    development {
        dataSource {
            pooled = true
            jmxExport = true
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            driverClassName = "com.mysql.jdbc.Driver"

            username = "root"
            password = "Toor@1984"

            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/mephistopheles?autoReconnect=true"
        }
    }
    test {
        dataSource {
            pooled = true
            jmxExport = true
            driverClassName = "org.h2.Driver"

            username = "sa"
            password = ""

            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
}