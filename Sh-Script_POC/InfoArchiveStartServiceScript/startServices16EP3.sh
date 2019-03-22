# !/bin/bash
rm -r 16EP3log
mkdir -p 16EP3log

echo "Starting xdb-server"
sh /Users/admin/Work/OpenText/infoarchive16EP3/xDB/bin/xdb-server > /Users/admin/Work/OpenText/16EP3log/xdb-server.log &
echo "Starting infoarchive webapp" 
sh /Users/admin/Work/OpenText/infoarchive16EP3/bin/infoarchive-webapp > /Users/admin/Work/OpenText/16EP3log/ia-webapp.log &
echo "Starting infoarchive server" 
sh /Users/admin/Work/OpenText/infoarchive16EP3/bin/infoarchive-server > /Users/admin/Work/OpenText/16EP3log/ia-server.log &

echo "Started all services for InfoArchive16EP3"