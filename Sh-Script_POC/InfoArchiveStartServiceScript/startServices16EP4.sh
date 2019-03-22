# !/bin/bash
rm -r 16EP4log
mkdir -p 16EP4log

echo "Starting xdb-server"
sh /Users/admin/Work/OpenText/infoarchive16EP4/xDB/bin/xdb-server > /Users/admin/Work/OpenText/16EP4log/xdb-server.log &
echo "Starting infoarchive webapp" 
sh /Users/admin/Work/OpenText/infoarchive16EP4/bin/iawebapp > /Users/admin/Work/OpenText/16EP4log/iawebapp.log &
echo "Starting infoarchive server" 
sh /Users/admin/Work/OpenText/infoarchive16EP4/bin/iaserver > /Users/admin/Work/OpenText/16EP4log/iaserver.log &

echo "Started all services for InfoArchive16EP4"