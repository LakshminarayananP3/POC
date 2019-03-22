# !/bin/bash
rm -r 16EP5log
mkdir -p 16EP5log

echo "Starting xdb-server"
sh /Users/admin/Work/OpenText/infoarchive16EP5/xDB/bin/xdb-server >> /Users/admin/Work/OpenText/16EP5log/xdb-server.log &
echo "Starting infoarchive webapp" 
sh /Users/admin/Work/OpenText/infoarchive16EP5/bin/iawebapp >> /Users/admin/Work/OpenText/16EP5log/iawebapp.log &
echo "Starting infoarchive server" 
sh /Users/admin/Work/OpenText/infoarchive16EP5/bin/iaserver >> /Users/admin/Work/OpenText/16EP5log/iaserver.log &

echo "Started all services for InfoArchive16EP5"