package mephistopheles

class ContactReportResult {

    String relationship
    int count

    @Override
    String toString() {
        return "$relationship: $count"
    }
}
