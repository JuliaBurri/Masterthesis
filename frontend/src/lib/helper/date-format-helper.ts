export function formatDate(date: Date) {
    //TODO: Format DD.MM.YYYY
    return date
}

export function getDateTime(date: String) {
    //TODO: Format hh:mm
    // @ts-ignore
    let d = new Date(date);
    return ('0'+d.getHours()).substr(-2) + ":" + ('0'+d.getMinutes()).substr(-2);
}
