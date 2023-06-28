docker run --name crud-mssql -d -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=reallyStrongPwd123' -p 2007:1433 mcr.microsoft.com/azure-sql-edge


/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P reallyStrongPwd123



