start: run create

run:
	docker-compose up --detach

create:
	docker exec -it yiialkalmi_postgres_1 psql -h localhostF -d appdb -U user -f initA.sql
	#docker exec -it yiialkalmi_postgres_1 bash entrypointA.sh