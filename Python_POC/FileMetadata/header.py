import exifread
# Open image file for reading (binary mode)
f = open('A0417658.tiff', 'rb')

# Return Exif tags
tags = exifread.process_file(f)

# Print the tag/ value pairs
for tag in tags.keys():
    if tag not in ('JPEGThumbnail', 'TIFFThumbnail', 'Filename', 'EXIF MakerNote'):
        print "Key: %s, value %s" % (tag, tags[tag])
